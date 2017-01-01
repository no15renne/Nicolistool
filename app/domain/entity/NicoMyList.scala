package domain.entity

import play.api.libs.json._
import play.api.libs.functional.syntax._
import org.json4s._
import org.json4s.native.JsonMethods
import org.json4s.native.Serialization

case class NicoMyList(
                       id: String,
                       user_id: String,
                       name: String,
                       public: String,
                       default_sort: String,
                       create_time: Long,
                       update_time: Long,
                       sort_order: String,
                       icon_id: String
                     ) {}

object NicoMyList {
  implicit val readFormats = DefaultFormats
  implicit val writeFormats = Serialization.formats(NoTypeHints)

  def fromJson4s(obj: JValue): NicoMyList = obj.extract[NicoMyList]
  def toJsonStr(nicoMyList: NicoMyList): String = Serialization.write(nicoMyList)

  implicit val jsonFormat = (
    (__ \ "id").format[String] ~
      (__ \ "user_id").format[String] ~
      (__ \ "name").format[String] ~
      (__ \ "public").format[String] ~
      (__ \ "default_sort").format[String] ~
      (__ \ "create_time").format[Long] ~
      (__ \ "update_time").format[Long] ~
      (__ \ "sort_order").format[String] ~
      (__ \ "icon_id").format[String]
    ) (NicoMyList.apply, unlift(NicoMyList.unapply))
}
