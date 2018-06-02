package com.fireblend.uitest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.fireblend.uitest.R;
import com.fireblend.uitest.entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (GridView)findViewById(R.id.lista_contactos);

        setupList();
    }

    private void setupList() {
        final List<Contact> contacts = new ArrayList();

        //Lista ejemplo con datos estaticos. Normalmente, estos serían recuperados de una BD o un REST API.
        contacts.add(new Contact("Sergio", 28, "sergiome@gmail.com", "88854764"));
        contacts.add(new Contact("Andres", 1, "alex@gmail.com", "88883644"));
        contacts.add(new Contact("Andrea", 2, "andrea@gmail.com", "98714764"));
        contacts.add(new Contact("Fabian", 3, "fabian@gmail.com", "12345678"));
        contacts.add(new Contact("Ivan", 4, "ivan@gmail.com", "87654321"));
        contacts.add(new Contact("Gabriela", 5, "gabriela@gmail.com", "09871234"));
        contacts.add(new Contact("Alex", 6, "sergiome@gmail.com", "43215678"));

        //Le asignamos a la lista un nuevo BaseAdapter, implementado a continuación
        list.setAdapter(new BaseAdapter() {
            @Override
            //Retorna el numero de elementos en la lista.
            public int getCount() {
                return contacts.size();
            }

            @Override
            //Retorna el elemento que pertenece a la posición especificada.
            public Object getItem(int position) {
                return contacts.get(position);
            }

            @Override
            //Devuelve un identificador único para cada elemento de la lista.
            //En nuestro caso, basta con devolver la posición del elemento en la lista.
            public long getItemId(int position) {
                return position;
            }

            @Override
            //Devuelve la vista que corresponde a cada elemento de la lista
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = getLayoutInflater();
                View row = inflater.inflate(R.layout.contact_item, parent, false);

                TextView name, age, phone, email;

                name = (TextView) row.findViewById(R.id.name);
                age = (TextView) row.findViewById(R.id.age);
                phone = (TextView) row.findViewById(R.id.phone);
                email = (TextView) row.findViewById(R.id.email);

                Button btn = (Button) row.findViewById(R.id.row_btn);

                //Basandonos en la posicion provista en este metodo, proveemos los datos
                //correctos para este elemento.
                final int pos = position;
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Hola, "+contacts.get(pos).name, Toast.LENGTH_SHORT).show();
                    }
                });

                name.setText(contacts.get(position).name);
                age.setText(contacts.get(position).age+"");
                phone.setText(contacts.get(position).phone);
                email.setText(contacts.get(position).email);

                return row;
            }
        });
    }
}
