package dev.nomadblacky.digdag_plugin_example_scala

import io.digdag.spi.{Operator, OperatorContext, OperatorFactory, TaskResult}
import io.digdag.util.BaseOperator
import org.slf4j.LoggerFactory

class ExampleOperator(_context: OperatorContext) extends BaseOperator(_context) {

  private[this] val logger = LoggerFactory.getLogger(classOf[ExampleOperator])

  override def runTask(): TaskResult = {
    logger.info("Hello, Digdag!")
    TaskResult.empty(request)
  }
}

class ExampleOperatorFactory extends OperatorFactory {
  override def getType: String = "example"

  override def newOperator(context: OperatorContext): Operator =
    new ExampleOperator(context)
}
