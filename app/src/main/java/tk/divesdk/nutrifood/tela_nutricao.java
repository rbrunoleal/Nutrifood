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


import static android.widget.AdapterView.*;


public class tela_nutricao extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tela_nutricao, container, false);

        ListView list;

        final String[] items_nome = new String[] {"Frutas","Legumes","Leguminosas","Cereais","Frutos-secos", "Especiarias","Nutrientes"};
        String[] items_desc = new String[] {"Informações sobre frutas.","Informações sobre legumes.", "Informações sobre leguminosas.", "Informações sobre cereais.", "Informações sobre frutos-secos.", "Informações sobre especiarias.", "Informações sobre nutrição."};
        Integer[] imgid = {R.drawable.frutasmini,R.drawable.legumesmini,R.drawable.leguminosasmini,R.drawable.cereaismini,R.drawable.frutossecosmini,R.drawable.especiariasmini,R.drawable.nutrientesmini,};

        list_adapter adapter= new list_adapter(getActivity(), items_nome, imgid,items_desc);

        list = (ListView) view.findViewById(R.id.listView);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(getActivity(), tela_frutas.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getActivity(), tela_legumes.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getActivity(), tela_leguminosas.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getActivity(), tela_cereais.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getActivity(), tela_frutossecos.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getActivity(), tela_especiarias.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getActivity(), tela_nutrientes.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        return view;
    }
}


