package com.example.material_3.ui

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.material_3.R
import com.example.material_3.databinding.FragmentWikiBinding

const val WIKI = "https://ru.wikipedia.org/wiki/"

class WikiFragment : Fragment(R.layout.fragment_wiki) {

    companion object {
        fun newInstance() = WikiFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding  = FragmentWikiBinding.bind(view)
        binding.web.webViewClient = WebViewClient()

        binding.inputLayout.setEndIconOnClickListener {
            binding.web.loadUrl(WIKI + binding.inputEditText.text)
        }
    }

}