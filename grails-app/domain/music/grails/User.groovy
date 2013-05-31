package music.grails

class User {
    String username

    String password

    String nickname

    static hasMany = [songs: Song]

    static constraints = {
        nickname nullable: true
    }
}
