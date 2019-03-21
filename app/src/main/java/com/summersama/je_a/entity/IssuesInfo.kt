package com.summersama.je_a.entity

import org.json.JSONObject

class IssuesInfo {
    var url: String = ""
    var repository_url: String = ""
    var labels_url: String = ""
    var comments_url: String = ""
    var events_url: String = ""
    var html_url: String = ""
    var id: Int = 0
    var node_id: String = ""
    var number: Int = 0
    var title: String = ""
    var user: User = User()
    var labels:List<JSONObject> = ArrayList() // fixme 不知道该转成啥 就先转JSONObject了
    var state: String = ""
    var locked: Boolean = false
    var assignee: JSONObject = JSONObject() //null
    var assignees: List<JSONObject> = ArrayList()
    var milestone:JSONObject=JSONObject()
    var comments:Int=0
    var created_at:String=""
    var updated_at:String=""
    var closed_at:String=""
    var author_association:String=""
    var body:String=""
    var score:Float=0f

    override fun toString(): String {
        return "{url:"+url+",repository_url:"+repository_url+",body:"+body+"}"
    }
}
