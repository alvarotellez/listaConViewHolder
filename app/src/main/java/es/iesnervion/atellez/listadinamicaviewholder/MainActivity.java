package es.iesnervion.atellez.listadinamicaviewholder;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    TextView seleccion;
    String [] saludos ={"Hola", "Bonjour", "Hello",
            "Hallo", "مرحبا",
            "Բարեւ Ձեզ", "もしもし", "Γεια σας", "salam", "Здравейте",
            "Haló", "你好", "Bok", "Tere", "Helo","Salve"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista);
        seleccion = (TextView) findViewById(R.id.seleccion);
        setListAdapter(new IconicAdapter<String>(this, R.layout.row, R.id.label, saludos));
    }
    public void onListItemClick(ListView parent, View v, int position, long id) {
       seleccion.setText(saludos[position]);
    }

    class IconicAdapter<T> extends ArrayAdapter<T> {
        IconicAdapter(Context c, int resourceId, int texId, T [] objects) {
            super(c, resourceId, texId, objects);
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;
            ViewHolder holder;

            if (row==null){
                LayoutInflater inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.row, parent, false);

                holder = new ViewHolder (row,R.id.label,R.id.icon);
                row.setTag(holder);
            }else{
                holder = (ViewHolder) row.getTag();
            }
            holder.getLab().setText(saludos[position]);
            if (saludos[position].equals("Hello")) {
                holder.getImg().setImageResource(R.drawable.cancel);
            }
            else if (saludos[position].equals("Hola")){
                holder.getImg().setImageResource(R.drawable.cancel);
            }
            else if (saludos[position].equals("Hallo")){
                holder.getImg().setImageResource(R.drawable.cancel);
            }
            else{
                holder.getImg().setImageResource(R.drawable.cancel);
            }
            return(row);
        }
        private class ViewHolder {
            TextView tv;
            ImageView img;

            ViewHolder (View row, int labId, int imgId){
                this.tv = (TextView) row.findViewById(labId);
                this.img = (ImageView) row.findViewById(imgId);
            }
            public TextView getLab (){
                return this.tv;
            }

            public ImageView getImg (){
                return this.img;
            }
        }
    }

}

