package domain.entity

import play.api.libs.json._
import play.api.libs.functional.syntax._
import org.json4s._
import org.json4s.native.JsonMethods
import org.json4s.native.Serialization

case class NicoVideo(
                      video_id: String,
                      title: String,
                      thumbnail_url: String
                    ) {}

object NicoVideo {
  implicit val readFormats = DefaultFormats
  implicit val writeFormats = Serialization.formats(NoTypeHints)

  def fromJson4s(obj: JValue): NicoVideo = obj.extract[NicoVideo]

  def toJsonStr(nicoVideo: NicoVideo): String = Serialization.write(nicoVideo)

  implicit val jsonFormat = (
    (__ \ "video_id").format[String] ~
      (__ \ "title").format[String] ~
      (__ \ "thumbnail_url").format[String]
    ) (NicoVideo.apply, unlift(NicoVideo.unapply))
}
