package controllers.api

import dispatch._
import Defaults._
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import org.json4s.native.JsonMethods._
import org.json4s.JsonDSL._
import play.api._
import play.api.libs.json._
import play.api.mvc._
import com.ning.http.client.cookie.Cookie
import domain.entity.NicoMyList
import infrastructure.service.NicoAPIVideoService

class NicoVideoAPIController extends AbstractNicoVideoAPIController {}

abstract class AbstractNicoVideoAPIController extends Controller {
  def readTags(id: Int) = Action.async {
    implicit val writeFormats = Serialization.formats(NoTypeHints)
    for {
      videoTags <- NicoAPIVideoService.getTags(id.toString)
    } yield Ok(Serialization.write(Map("tags" -> videoTags)))
      .withHeaders("Access-Control-Allow-Origin" -> " *")
  }
}
