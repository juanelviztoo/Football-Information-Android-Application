package com.l0122054.elviztojuan.thewonderfulworldoffootball.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.l0122054.elviztojuan.thewonderfulworldoffootball.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inisialisasi buttonGoToInstagram dan buttonGoToLinkedIn dari binding
        val buttonGoToInstagram = binding.buttonGoToInstagram
        val buttonGoToLinkedIn = binding.buttonGoToLinkedIn

        // Ketika tombol Go To LinkedIn ditekan
        buttonGoToLinkedIn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/in/elvizto-juan-khresnanda-29896525b/")
            startActivity(intent)
        }
        // Ketika tombol Go To Instagram ditekan di dalam fragment
        buttonGoToInstagram.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.instagram.com/elviztojuan._.k/")
            startActivity(intent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}