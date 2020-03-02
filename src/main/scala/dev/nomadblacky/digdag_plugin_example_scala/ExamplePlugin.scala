package dev.nomadblacky.digdag_plugin_example_scala

import java.util

import io.digdag.spi.{OperatorFactory, OperatorProvider, Plugin}
import javax.inject.Inject

class ExamplePlugin extends Plugin {
  override def getServiceProvider[T](`type`: Class[T]): Class[_ <: T] =
    if (`type` eq classOf[OperatorProvider]) classOf[ExampleOperatorProvider].asSubclass(`type`) else null
}

class ExampleOperatorProvider @Inject() extends OperatorProvider {
  override def get(): util.List[OperatorFactory] = util.Arrays.asList(new ExampleOperatorFactory)
}
