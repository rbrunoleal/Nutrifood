package tk.divesdk.nutrifood;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class tela_contato extends ActionBarActivity {
    private static final String username = "enviocontatodivesdk@gmail.com";
    private static final String password = "divesapkmat220";
    private EditText emailEdit;
    private EditText subjectEdit;
    private EditText messageEdit;
    private EditText nomeEdit;
    int verifica=0;
    boolean net;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_contato);

        emailEdit = (EditText) findViewById(R.id.email);
        subjectEdit = (EditText) findViewById(R.id.subject);
        messageEdit = (EditText) findViewById(R.id.message);
        nomeEdit = (EditText) findViewById(R.id.nome);
        Button sendButton = (Button) findViewById(R.id.send);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                net=verificaConexao();
                if(net==true){
                    verifica = 0;
                    validacampo(nomeEdit);
                    validacampo(emailEdit);
                    validacampo(subjectEdit);
                    validacampo(messageEdit);
                    if(verifica == 1) {
                        Toast.makeText(getApplicationContext(), "Por favor, Preencha Todos Os Campos!", Toast.LENGTH_LONG).show();
                    }
                    if (verifica == 0) {
                        String email = emailEdit.getText().toString();
                        String subject = "Contato NutriFood";
                        String message = "NOME:" + nomeEdit.getText().toString() + " EMAIL:" + email + " ASSUNTO:" + subjectEdit.getText().toString() + " MENSAGEM:" + messageEdit.getText().toString();
                        sendMail(email, subject, message);

                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Falha Ao Tentar Enviar Mensagem, Por Favor Verifique Sua Conexão Com a Internet", Toast.LENGTH_SHORT).show();
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public  boolean verificaConexao() {

        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            return true;

        } else {
            return false;
        }

    }

    // Analytics.
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance(this).activityStart(this);
    }
    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance(this).activityStop(this);
    }

    protected void validacampo( EditText verif){

        if ( verif.getText().toString().equals("") ) {
            verifica=1;
        }

    }

    private void sendMail(String email, String subject, String messageBody) {
        EasyTracker tracker = EasyTracker.getInstance(tela_contato.this);
        tracker.send(MapBuilder.createEvent("Botão", "Click", "Envio de E-mail", 10L).build());
        Session session = createSessionObject();
        try {
            Message message = createMessage(email, subject, messageBody, session);
            new SendMailTask().execute(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private Message createMessage(String email, String subject, String messageBody, Session session) throws MessagingException, UnsupportedEncodingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("enviocontatodivesdk@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("contato@divesdk.tk"));
        message.setSubject(subject);
        message.setText(messageBody);
        return message;
    }

    private Session createSessionObject() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.port", "465");

        return Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private class SendMailTask extends AsyncTask<Message, Void, Void> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(tela_contato.this, "Aguarde", "Enviando E-mail", true, false);

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(),"Mensagem Enviada Com Sucesso!", Toast.LENGTH_SHORT).show();

        }


        @Override
        protected Void doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);

            }
            catch (MessagingException e) {

                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Id correspondente ao botão Up/Home da actionbar
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

}