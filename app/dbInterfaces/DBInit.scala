package dbInterfaces

import org.joda.time.DateTime
import slick.jdbc.PostgresProfile.api._
import slick.jdbc.meta.MTable

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import HospitalTable.{query => hospitalQuery}
import com.google.inject.Singleton

@Singleton
class DBInit {

  val tables = List(hospitalQuery)

  def createTable: Future[List[Unit]] = DBConnect.exec(MTable.getTables.flatMap(existingTables => {
    val names = existingTables.map(mTable => mTable.name.name)
    val createIfNotExist = tables.filter(table =>
      !names.contains(table.baseTableRow.tableName)).map(_.schema.create)
    DBIO.sequence(createIfNotExist)
  }))

  DBConnect.exec(hospitalQuery += Hospital(-1L, "sw", "ss", "sd"))

  Await.result(createTable, Duration.Inf)

}
