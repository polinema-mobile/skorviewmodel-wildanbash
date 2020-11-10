package id.ac.polinema.skorviewmodel.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import id.ac.polinema.skorviewmodel.fragments.ScoreFragment
import id.ac.polinema.skorviewmodel.fragments.ScoreFragmentDirections
import id.ac.polinema.skorviewmodel.models.GoalScorer

class ScoreViewModel : ViewModel() {
    private val homeGoalScorerList = MutableLiveData(ArrayList<GoalScorer?>())
    private val awayGoalScorerList = MutableLiveData(ArrayList<GoalScorer?>())

    val homeScore: Int?
        get() = homeGoalScorerList.value?.size
    val awayScore: Int?
        get() = awayGoalScorerList.value?.size

    fun setGoalScorer(team: String?, goalScorer: GoalScorer?) {
        if (team == ScoreFragment.HOME) {
            homeGoalScorerList.value?.add(goalScorer)
        } else {
            awayGoalScorerList.value?.add(goalScorer)
        }
    }

    fun onAddHomeClick(view: View) {
        val action = ScoreFragmentDirections.goalScorerAction(ScoreFragment.HOME)
        Navigation.findNavController(view).navigate(action)
        Log.d("clickbutton", "di click")
    }

    fun onAddAwayClick(view: View) {
        val action = ScoreFragmentDirections.goalScorerAction(ScoreFragment.AWAY)
        Navigation.findNavController(view).navigate(action)
    }

    fun getHomeScorer(): String{
        var homeScorer = ""
        for (gs in homeGoalScorerList.value!!){
            homeScorer += ("${gs?.name} ${gs?.minute}\" ")
        }
        return homeScorer
    }

    fun getAwayScorer(): String {
        var awayScorer = ""
        for (gs in awayGoalScorerList.value!!){
            awayScorer += ("${gs?.name} ${gs?.minute}\" ")
        }
        return awayScorer
    }
}