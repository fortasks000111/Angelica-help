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

    private lateinit var mean_val: EditText
    private lateinit var variance_val: EditText
    private lateinit var random_number_result: TextView
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
        mean_val = view.findViewById(R.id.mean_val)
        variance_val = view.findViewById(R.id.variance_value)
        random_number_result = view.findViewById(R.id.random_number_result)
        btn = view.findViewById(R.id.get_random_num)

        mean_val.setText(viewModel.mean_val?.toString()?:getString(R.string.empty))
        variance_val.setText(viewModel.variance_val?.toString()?: getString(R.string.empty))
        random_number_result.setText(viewModel.random_number_result?.toString()?: getString(R.string._0))
        btn.setText(R.string.button_text)


        mean_val.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val input = p0.toString()
                viewModel.mean_val = input.toDoubleOrNull()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        variance_val.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val input = p0.toString()
                viewModel.variance_val = input.toDoubleOrNull()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        btn.setOnClickListener {
            if (viewModel.getResult() != null)
            {
                random_number_result.setText(viewModel.random_number_result.toString())
            }
            else random_number_result.setText(getString(R.string.result))
        }

        return view
    }

}