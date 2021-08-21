package com.kemanci.yummyfood.ui.home_fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kemanci.yummyfood.databinding.HomeFragmentBinding
import com.kemanci.yummyfood.model.entity.AccountResponse
import com.kemanci.yummyfood.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var accountResponse:AccountResponse? = null
    private lateinit var binding:HomeFragmentBinding
    private val viewModel:HomeViewModel by viewModels()
    private lateinit var ordersRecyclerView: RecyclerView
    private lateinit var orderRecyclerViewAdapter: OrderRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  HomeFragmentBinding.inflate(layoutInflater,container,false)
        accountResponse =  HomeFragmentArgs.fromBundle(requireArguments()).accountResponse
        ordersRecyclerView = binding.previousOrderRecyclerView
        ordersRecyclerView.layoutManager = LinearLayoutManager(this.context)
        orderRecyclerViewAdapter = OrderRecyclerViewAdapter(
            context = this.requireContext(),
            ordersList = accountResponse!!.account.orders!!
        )

        ordersRecyclerView.adapter  = orderRecyclerViewAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeOrders()
    }

    fun getProfile(){
        if (accountResponse!=null) return
        viewModel.profile(accountResponse!!.token).observe(viewLifecycleOwner,{
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS ->{

                }
                Resource.Status.ERROR -> {

                }
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    fun observeOrders(){
        binding.progressLayout.visibility = View.VISIBLE
        accountResponse!!.account.orders!!.forEach { order ->
            viewModel.getFoodById(order.food_id).observe(viewLifecycleOwner,{
                if(it.status == Resource.Status.SUCCESS){
                    if (order.food_id!=it.data!!._id){
                        Log.e("TAG", "observeOrders:yemek hata var" )
                    }
                    order.foodName = it.data.name;
                    order.foodPrice = it.data.price;
                    this.orderRecyclerViewAdapter.notifyDataSetChanged()
                    binding.progressLayout.visibility = View.GONE

                }
            })
            viewModel.getRestaurantById(order.restaurant_id).observe(viewLifecycleOwner,{
                if(it.status == Resource.Status.SUCCESS){
                    if(order.restaurant_id!=it.data!!._id){
                        Log.e("TAG", "observeOrders:restoran hata var" )
                    }
                    order.restaurantName = it.data.name
                    order.restaurantPoint = it.data.point.toString()
                    this.orderRecyclerViewAdapter.notifyDataSetChanged()
                    binding.progressLayout.visibility = View.GONE
                }
            })
        }
    }
}