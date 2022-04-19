package com.example.tz1.ui.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tz1.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var prefs: SharedPreferences

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
                ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textNameView: TextView = binding.textName
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textNameView.text = "Имя: Александр"
        }
        val textSecNameView: TextView = binding.textSecName
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textSecNameView.text = "Фамилия: Межов"
        }
        val textInstituteView: TextView = binding.textInstitute
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textInstituteView.text = "Институт: БГТУ им.Шухова"
        }
        val textKafedraView: TextView = binding.textKafedra
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textKafedraView.text = "Кафедра: ПОВТиАС"
        }
        val textGroupView: TextView = binding.textGroup
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textGroupView.text = "Группа: ВТ-41"
        }

        prefs = requireActivity().getSharedPreferences("wallet", Context.MODE_PRIVATE)
        val balance = prefs.getInt("balance", 0)
        val textBalanceView: TextView = binding.textBalance
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textBalanceView.text = "Текущий баланс: " + balance.toString() + " SK8"
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}