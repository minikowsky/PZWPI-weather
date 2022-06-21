package com.example.aplikacjapogodowa.ui

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.*
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.aplikacjapogodowa.tools.Unit
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.aplikacjapogodowa.MainActivity
import com.example.aplikacjapogodowa.R

class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //get user preferences to get unit
        val sharedPref = (activity as MainActivity).applicationContext.getSharedPreferences("UserPreferences",MODE_PRIVATE)

        //setting current unit
        when(sharedPref.getString("Unit", Unit.METRIC)){
            Unit.METRIC -> view.findViewById<RadioButton>(R.id.units_radio_metric).isChecked = true
            Unit.IMPERIAL -> view.findViewById<RadioButton>(R.id.units_radio_imperial).isChecked = true
            Unit.STANDARD -> view.findViewById<RadioButton>(R.id.units_radio_standard).isChecked = true
        }
        view.findViewById<RadioGroup>(R.id.units_radio_group)
            .setOnCheckedChangeListener{_, checkedId ->
                //when radiobutton is clicked(changed), update user preferences
                when(checkedId) {
                    R.id.units_radio_metric ->
                        with (sharedPref.edit()) {
                            putString("Unit", Unit.METRIC)
                            apply()
                        }
                    R.id.units_radio_imperial ->
                        with (sharedPref.edit()) {
                            putString("Unit", Unit.IMPERIAL)
                            apply()
                        }
                    R.id.units_radio_standard ->
                        with (sharedPref.edit()) {
                            putString("Unit", Unit.STANDARD)
                            apply()
                        }
                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_settings,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_action_weather) {
            view?.findNavController()?.navigate(R.id.action_settingsFragment_to_weatherFragment)
        }
        return super.onOptionsItemSelected(item)
    }


}