import grails.converters.JSON
import music.grails.Song
import music.grails.Tag
import music.grails.User

class BootStrap {

    def init = { servletContext ->
        def user = new User(username: 'pfollia', password: 'password', nickname: 'madchicken')
        user.save()

        def song1 = new Song(name: 'Fear Of A Blank Planet')
        def song2 = new Song(name: 'Anesthetize')
        def song3 = new Song(name: 'Degree Zero Of Liberty')
        user.addToSongs(song1)
        user.addToSongs(song2)
        user.addToSongs(song3)

        def tag1 = new Tag(type: 'ARTIST', tag: 'PORCUPINE TREE')
        tag1.save()
        song1.addToTags(tag1)
        song2.addToTags(tag1)
        song3.addToTags(tag1)


        JSON.registerObjectMarshaller(User) {
            [
                    id: it.id,
                    username: it.username,
                    nickname: it.nickname,
                    songs: it.songs
            ]
        }

        JSON.registerObjectMarshaller(Song) { song ->
            [
                    id: song.id,
                    name: song.name,
                    tags: song.tags
            ]
        }

        JSON.registerObjectMarshaller(Tag) { tag ->
            [
                    id: tag.id,
                    type: tag.type,
                    tag: tag.tag
            ]
        }
    }

    def destroy = {
    }
}
