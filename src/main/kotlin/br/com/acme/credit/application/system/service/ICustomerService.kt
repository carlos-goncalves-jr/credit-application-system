package br.com.acme.credit.application.system.service

import br.com.acme.credit.application.system.model.Customer

interface ICustomerService {
    fun save(customer: Customer) : Customer
    fun findById(id: Long) : Customer
    fun deleteByid(id: Long)
}