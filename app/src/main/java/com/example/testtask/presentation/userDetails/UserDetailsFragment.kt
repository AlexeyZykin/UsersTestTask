package com.example.testtask.presentation.userDetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.testtask.databinding.FragmentUserDetailsBinding
import com.example.testtask.presentation.main.MainActivity
import com.example.testtask.presentation.utils.DateTypeConverter
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserDetailsFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailsBinding
    private val args: UserDetailsFragmentArgs by navArgs()
    private val viewModel by viewModel<UserDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserDetails(args.userId)
        viewModel.userDetails.observe(viewLifecycleOwner) { user ->
            binding.apply {
                (activity as MainActivity).supportActionBar?.title = user.login.username
                Picasso.get().load(user.picture.large).into(imageUser)
                tvName.text = "${user.name.first} ${user.name.first} ${user.name.last}"
                tvGender.text = user.gender
                tvNat.text = user.nat
                tvDob.text = DateTypeConverter.convertDateToString(user.dob.date)
                tvPhoneNumber.text = user.phone
                tvCountry.text = user.location.country
                tvCity.text = user.location.city
                tvStreet.text = "${user.location.street.number} ${user.location.street.name}"
                tvPostcode.text = user.location.postcode
                tvTimezone.text =
                    "${user.location.timezone.offset} ${user.location.timezone.description}"
                tvCoordinates.text =
                    "${user.location.coordinates.latitude},${user.location.coordinates.longitude}"
                tvEmail.text = user.email
                tvUsername.text = user.login.username
                tvPassword.text = user.login.password
            }
        }

        binding.tvPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${binding.tvPhoneNumber.text}")
            startActivity(intent)
        }

        binding.tvStreet.setOnClickListener {
            val uriString = "geo:0,0?q=${binding.tvStreet.text}+${binding.tvCity.text}"
            getLocationMap(uriString)
        }

        binding.tvCoordinates.setOnClickListener {
            val uriString = "geo:${binding.tvCoordinates.text}"
            getLocationMap(uriString)
        }
    }

    private fun getLocationMap(uriString: String) {
        val geoUri = Uri.parse(uriString)
        val intent = Intent(Intent.ACTION_VIEW, geoUri)
        intent.resolveActivity(requireActivity().packageManager)?.let {
            startActivity(intent);
        }
    }

}
