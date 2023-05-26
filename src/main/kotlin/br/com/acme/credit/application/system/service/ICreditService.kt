package br.com.acme.credit.application.system.service

import br.com.acme.credit.application.system.model.Credit
import java.util.*

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerId: Long): List<Credit>
    fun findByCreditCode(creditCode: UUID) : Credit
}