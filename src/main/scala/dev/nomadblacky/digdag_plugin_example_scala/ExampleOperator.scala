package dev.nomadblacky.digdag_plugin_example_scala

import com.fasterxml.jackson.databind.ObjectMapper
import io.digdag.spi.{Operator, OperatorContext, OperatorFactory, TaskResult}
import io.digdag.util.BaseOperator
import org.slf4j.LoggerFactory

import scala.jdk.CollectionConverters._

class ExampleOperator(_context: OperatorContext) extends BaseOperator(_context) {

  private[this] val logger = LoggerFactory.getLogger(classOf[ExampleOperator])

  override def runTask(): TaskResult = {
    val config = this.request.getConfig
    val pretty = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(config)
    logger.info(pretty)

    logger.info("key = {}", config.get("key", classOf[String]))
    logger.info("array = {}", config.getList("array", classOf[Int]).asScala.toSeq)

    TaskResult.empty(this.request)
  }
}

class ExampleOperatorFactory extends OperatorFactory {
  override def getType: String = "example"

  override def newOperator(context: OperatorContext): Operator =
    new ExampleOperator(context)
}
