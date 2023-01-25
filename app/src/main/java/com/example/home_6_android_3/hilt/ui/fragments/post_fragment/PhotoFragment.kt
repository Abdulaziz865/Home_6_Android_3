package com.example.home_6_android_3.hilt.ui.fragments.post_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.home_6_android_3.databinding.FragmentPhotoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoFragment : Fragment() {

    private var binding: FragmentPhotoBinding? = null
    private val viewModel by viewModels<PhotosViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRequests()
        setUpObserves()
    }

    private fun setUpRequests() = binding?.let {
        binding?.btnSend?.setOnClickListener {
            val id = binding?.edId?.text.toString().toInt()
            val title = binding?.edTitle?.text.toString().trim()
            val url = binding?.edUrl?.text.toString().trim()
            val thumbnailUrl = binding?.edThumbnailUrl?.text.toString().trim()
            viewModel.sendPhoto(
                albumId = 101, id = id, title = title, url = url, thumbnailUrl = thumbnailUrl
            )
        }
    }

    private fun setUpObserves() {
        viewModel.photoLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}