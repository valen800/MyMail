package org.ieselcaminas.valentin.mymail.ui.inbox

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.ieselcaminas.valentin.mymail.Mail
import org.ieselcaminas.valentin.mymail.MailAdapter
import org.ieselcaminas.valentin.mymail.R
import org.ieselcaminas.valentin.mymail.ui.MailContentActivity


class InboxFragment : Fragment() {

    private lateinit var inboxViewModel: InboxViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inboxViewModel =
            ViewModelProviders.of(this).get(InboxViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_inbox, container, false)

        val items = ArrayList<Mail>()

        items.add(Mail(R.drawable.ic_mail, R.string.valentin))
        items.add(Mail(R.drawable.ic_mail, R.string.alberto))
        items.add(Mail(R.drawable.ic_mail, R.string.juan))

        val recyclerMails = root.findViewById(R.id.recyclerMails) as RecyclerView

        val adaptador = MailAdapter(items)
        recyclerMails.adapter = adaptador
        recyclerMails.layoutManager =
            LinearLayoutManager(context)

        adaptador.onClick = {
            val intent = Intent(context, MailContentActivity::class.java)

            //Animación aplicada sobre ambas actividades
            //Animación aplicada sobre ambas actividades
            val options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(activity!!).toBundle()

            val item: Mail = items.get(recyclerMails.getChildAdapterPosition(it))
            options!!.putInt("NOM", item.text)

            //Añadimos la información al Intent
            //Añadimos la información al Intent
            intent.putExtras(options)
            startActivity(intent, options)

        }

        return root
    }
}