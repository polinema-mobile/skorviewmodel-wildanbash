package id.ac.polinema.skorviewmodel.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.polinema.skorviewmodel.R
import id.ac.polinema.skorviewmodel.databinding.FragmentScoreBinding
import id.ac.polinema.skorviewmodel.viewmodels.ScoreViewModel

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {
    private lateinit var viewModel: ScoreViewModel

    companion object {
        const val HOME = "home"
        const val AWAY = "away"
        const val SCORER_KEY = "scorer"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentScoreBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_score, container, false)
        // instance viewmodel here
        binding.fragment = this
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(requireActivity()).get(ScoreViewModel::class.java)
        binding.vm = viewModel
        return binding.root
    }
}