package com.example.angelicahelp.ui.mainscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.angelicahelp.R

class MainScreen : Fragment() {
    private lateinit var viewModel: MainScreenViewModel

    private lateinit var meanValue: EditText
    private lateinit var varianceValue: EditText
    private lateinit var randomNumber: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val view = inflater.inflate(R.layout.fragment_main_screen, container, false)
        viewModel = ViewModelProvider(this).get(MainScreenViewModel::class.java)
        meanValue = view.findViewById(R.id.mean_val)
        varianceValue = view.findViewById(R.id.variance_value)
        randomNumber = view.findViewById(R.id.random_number_result)
        btn = view.findViewById(R.id.get_random_num)

        meanValue.setText(viewModel.mean?.toString()?:getString(R.string.empty))
        varianceValue.setText(viewModel.variance?.toString()?: getString(R.string.empty))
        randomNumber.setText(viewModel.randomNumber?.toString()?: getString(R.string._0))
        btn.setText(R.string.button_text)


        meanValue.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                return
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val input = p0.toString()
                viewModel.mean = input.toDoubleOrNull()
            }

            override fun afterTextChanged(p0: Editable?) {
                return
            }
        })

        varianceValue.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                return
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val input = p0.toString()
                viewModel.variance = input.toDoubleOrNull()
            }

            override fun afterTextChanged(p0: Editable?) {
                return
            }
        })

        btn.setOnClickListener {
            if (viewModel.getResult() != null)
            {
                randomNumber.setText(viewModel.randomNumber.toString())
            }
            else randomNumber.setText(getString(R.string.result))
        }

        return view
    }

}
