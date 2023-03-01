package mobi.sevenwinds.app.budget

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object BudgetTable : IntIdTable("budget") {
    val year = integer("year")
    val month = integer("month")
    val amount = integer("amount")
    val author_id = integer("author_id")
    val type = enumerationByName("type", 100, BudgetType::class)
}

class BudgetEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<BudgetEntity>(BudgetTable)

    var year by BudgetTable.year
    var month by BudgetTable.month
    var amount by BudgetTable.amount
    var type by BudgetTable.type

    fun toResponse(): BudgetRecord {
        return BudgetRecord(year, month, amount, type)
    }
}

object AuthorTable : IntIdTable("author") {
    val fio = text("fio")
    val created = datetime("created")
}

class AuthorEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AuthorEntity>(AuthorTable)

    var fio by AuthorTable.fio
    var created by AuthorTable.created

    fun toResponse(): AuthorRecord {
        return AuthorRecord(fio, created)
    }
}