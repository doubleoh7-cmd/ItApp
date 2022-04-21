package com.example.itapp.ui.Faculty_StaffDirectory

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.itapp.R
import com.example.itapp.databinding.FragmentFacultyBinding

class FacultyFragment : Fragment() {

    private var _binding: FragmentFacultyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFacultyBinding.inflate(inflater, container, false)

        val roseemail = "ithod@ucc.edu.jm"
        val soniaemail = "businessadminhod@ucc.edu.jm"
        val tomemail = "graduatestudiesdirector@ucc.edu.jm"
        val millemail = "appliedpsychologyfaculty@ucc.edu.jm"
        val peter = "headofschoolsmathit@ucc.edu.jm"
        val rosephone = "8760000000"
        val soniaphone = "8760000001"
        val tomephone = "8760000002"
        val millphone = "8760000003"
        val peterphone = "8760000004"

        binding.roseEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", roseemail, null))
            intent.putExtra(Intent.EXTRA_EMAIL, roseemail)
            startActivity(intent)
        }

        binding.peterEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", peter, null))
            intent.putExtra(Intent.EXTRA_EMAIL, peter)
            startActivity(intent)
        }

        binding.davidsonEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", soniaemail, null))
            intent.putExtra(Intent.EXTRA_EMAIL, soniaemail)
            startActivity(intent)
        }

        binding.tomEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", tomemail, null))
            intent.putExtra(Intent.EXTRA_EMAIL, tomemail)
            startActivity(intent)
        }

        binding.millerEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", millemail, null))
            intent.putExtra(Intent.EXTRA_EMAIL, millemail)
            startActivity(intent)
        }

        binding.roseNum.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$rosephone"))
            startActivity(intent)
        }

        binding.peterNum.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$peterphone"))
            startActivity(intent)
        }

        binding.tomNum.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$tomephone"))
            startActivity(intent)
        }

        binding.millerNum.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$millphone"))
            startActivity(intent)
        }

        binding.soniaNum.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$soniaphone"))
            startActivity(intent)
        }

        return binding.root
    }

}