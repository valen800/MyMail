package org.ieselcaminas.valentin.mymail.ui.outbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import org.ieselcaminas.valentin.mymail.R

class OutboxFragment : Fragment() {

    private lateinit var outboxViewModel: OutboxViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        outboxViewModel =
            ViewModelProviders.of(this).get(OutboxViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_outbox, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        outboxViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}