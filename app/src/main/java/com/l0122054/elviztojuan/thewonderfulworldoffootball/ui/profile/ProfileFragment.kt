package com.l0122054.elviztojuan.thewonderfulworldoffootball.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.l0122054.elviztojuan.thewonderfulworldoffootball.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by activityViewModels()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Mengamati perubahan data profil dari ProfileViewModel
        profileViewModel.profileData.observe(viewLifecycleOwner) { profile ->
            profile?.let {
                // Menampilkan data profil ke TextView
                binding.textFullName.text = it.fullName
                binding.textNim.text = it.nim
                binding.textMajorYear.text = it.majorBatch
                binding.textFaculty.text = it.faculty
                binding.textUniversity.text = it.university
                binding.textEmail.text = it.email
            }
        }

        // Mendapatkan referensi ke tombol Share
        val buttonShare = binding.buttonShare

        // Menambahkan aksi pada tombol Share
        buttonShare.setOnClickListener {
            val profile = profileViewModel.profileData.value
            profile?.let {
                // Membuat Intent untuk berbagi data profil
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "My Profile:\nFullname: ${it.fullName}\nNIM: ${it.nim}\nMajor, Year: ${it.majorBatch}\nFaculty: ${it.faculty}\nUniversity: ${it.university}\nEmail: ${it.email}"
                    )
                    type = "text/plain"
                }
                // Menampilkan dialog untuk memilih aplikasi berbagi
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            } ?: run {
                Log.e("ProfileFragment", "Profile Data is Null")
                Toast.makeText(requireContext(), "Profile Data is Null", Toast.LENGTH_SHORT).show()
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}