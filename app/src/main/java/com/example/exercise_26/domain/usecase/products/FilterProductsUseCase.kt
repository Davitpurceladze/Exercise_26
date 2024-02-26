package com.example.exercise_26.domain.usecase.products

import com.example.exercise_26.data.common.Resource
import com.example.exercise_26.domain.model.product.GetProducts
import com.example.exercise_26.domain.repository.home.ProductsRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilterProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {

    suspend operator fun invoke(searchedName: String) = withContext(IO) {
        return@withContext flow<Resource<List<GetProducts>>> {
            productsRepository.fetchProducts().collect{
                when(it) {
                    is Resource.Success -> emit(Resource.Success(data = filterProducts(products = it.data, searchedName)))
                    is Resource.Loading -> emit(Resource.Loading(loading = it.loading))
                    is Resource.Error -> emit(Resource.Error(errorMessage = it.errorMessage))
                }
            }
        }
    }


    private fun filterProducts(products: List<GetProducts>, searchedName: String  ) : MutableList<GetProducts> {
        val filteredProducts = mutableListOf<GetProducts>()
        var parent = 0
        for (product in products) {


            if(product.name.contains(searchedName, ignoreCase = true)) {
                filteredProducts.add(product.copy(numberOfParents =  ))

            }
            parent++
                filteredProducts.addAll(filterProducts(product.children, searchedName, ))
        }

        return filteredProducts
    }



}