package br.com.acme.credit.application.system.service.impl

import br.com.acme.credit.application.system.model.Credit
import br.com.acme.credit.application.system.repository.CreditRepository
import br.com.acme.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit?.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)


    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Credit Code $creditCode não encontrado")
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contate o administrador")
    }
}