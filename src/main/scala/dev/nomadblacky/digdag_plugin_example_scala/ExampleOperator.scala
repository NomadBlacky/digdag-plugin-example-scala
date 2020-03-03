package dev.nomadblacky.digdag_plugin_example_scala

import io.digdag.spi.{Operator, OperatorContext, OperatorFactory, TaskResult}
import io.digdag.util.BaseOperator
import org.slf4j.LoggerFactory

import scala.jdk.CollectionConverters._

class ExampleOperator(_context: OperatorContext) extends BaseOperator(_context) {

  private[this] val logger = LoggerFactory.getLogger(classOf[ExampleOperator])

  override def runTask(): TaskResult = {
    val config = this.request.getConfig

    val sum = config
      .getList("sum", classOf[Int])
      .asScala
      .sum

    val resultParams = {
      val params = config.getFactory.create()
      val result = params.getNestedOrSetEmpty("result")
      result.set("sum", sum)
      params
    }

    logger.info("Store the result to `result.sum` variable!")

    TaskResult.defaultBuilder(this.request).storeParams(resultParams).build()
  }
}

class ExampleOperatorFactory extends OperatorFactory {
  override def getType: String = "example"

  override def newOperator(context: OperatorContext): Operator =
    new ExampleOperator(context)
}
