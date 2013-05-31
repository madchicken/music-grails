package music.grails

class Tag {

    String type

    String tag

    static belongsTo = Song

    static hasMany = [songs: Song]

    static constraints = {
        type inList: ['GENERIC', 'ARTIST', 'GENRE']
    }
}
