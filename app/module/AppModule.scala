package module

import com.google.inject.{AbstractModule, Singleton}
import dbInterfaces.DBInit

@Singleton
class AppModule extends AbstractModule{
  override def configure(): Unit =bind(classOf[DBInit]).asEagerSingleton()
}
