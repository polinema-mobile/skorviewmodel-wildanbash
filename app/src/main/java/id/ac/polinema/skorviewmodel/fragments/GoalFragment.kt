package id.ac.polinema.skorviewmodel.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.polinema.skorviewmodel.R
import id.ac.polinema.skorviewmodel.databinding.FragmentGoalBinding
import id.ac.polinema.skorviewmodel.models.GoalScorer
import id.ac.polinema.skorviewmodel.viewmodels.ScoreViewModel

/**
 * A simple [Fragment] subclass.
 */
class GoalFragment : Fragment() {
    private lateinit var viewModel: ScoreViewModel
    private lateinit var requestKey: String
    private lateinit var goalScorer: GoalScorer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goalScorer = GoalScorer()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentGoalBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_goal, container, false)
        // instance viewmodel here
        binding.fragment = this
        binding.goalScorer = goalScorer
        requestKey = GoalFragmentArgs.fromBundle(requireArguments()).requestKey
        viewModel = ViewModelProvider(requireActivity()).get(ScoreViewModel::class.java)
        return binding.root
    }

    fun onSaveClicked(view: View) {
        val bundle = Bundle()
        bundle.putParcelable(ScoreFragment.SCORER_KEY, goalScorer)
        viewModel.setGoalScorer(requestKey, goalScorer)
        Navigation.findNavController(view).navigateUp()
    }

    fun onCancelClicked(view: View) {
        Navigation.findNavController(view).navigateUp()
    }
}