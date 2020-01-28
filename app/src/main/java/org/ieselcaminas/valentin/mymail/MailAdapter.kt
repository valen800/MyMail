package org.ieselcaminas.valentin.mymail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MailAdapter (var items: ArrayList<Mail>) : RecyclerView.Adapter<MailAdapter.TarjViewHolder>() {

    lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var text: TextView
        var img: ImageView

        init {
            text = itemView.findViewById(R.id.textBody) as TextView
            img = itemView.findViewById(R.id.imageMail) as ImageView
        }

        fun bindTarjeta(t: Mail, onClick: (View) -> Unit) = with(itemView) {
            text.setText(t.text)
            img.setImageResource(t.img)
            setOnClickListener{ onClick(itemView) }

            img.setOnClickListener{
                onClick(itemView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent,false )
        return TarjViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TarjViewHolder, position: Int) {
        val item = items.get(position)
        holder.bindTarjeta(item, onClick)
    }
}