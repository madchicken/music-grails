package music.grails

class Song {

    String name

    static hasMany = [tags: Tag]

    static constraints = {

    }
}
