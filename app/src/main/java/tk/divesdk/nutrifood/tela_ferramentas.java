package tk.divesdk.nutrifood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class tela_ferramentas extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tela_ferramentas, container, false);

        ListView list;

        final String[] items_nome = new String[] {"IMC", "PIRÂMIDE"};
        String[] items_desc = new String[] {"Calculo IMC.", "Pirâmide Nutricional."};
        Integer[] imgid = {R.drawable.imcmini, R.drawable.txgmini};

        list_adapter adapter= new list_adapter(getActivity(), items_nome, imgid,items_desc);

        list = (ListView) view.findViewById(R.id.listView2);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(getActivity(), tela_imc.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getActivity(), tela_piramide.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        return view;

    }


}
