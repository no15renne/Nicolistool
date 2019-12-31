package controllers.api

import dispatch._, Defaults._
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import org.json4s.native.JsonMethods._
import org.json4s.JsonDSL._
import play.api.mvc._
import com.ning.http.client.cookie.Cookie
import domain.entity.NicoVideo
import infrastructure.service.NicoAPIMyListItemsService

class NicoMyListItemsAPIController extends AbstractNicoMyListItemsAPIController {}

abstract class AbstractNicoMyListItemsAPIController extends Controller {
  def read(id: Int) = Action.async {
    implicit val writeFormats = Serialization.formats(NoTypeHints)
    for {
      myListItems <- NicoAPIMyListItemsService.get(id)
    } yield Ok(Serialization.write(myListItems)).withHeaders("Access-Control-Allow-Origin" -> " *")
  }
}
