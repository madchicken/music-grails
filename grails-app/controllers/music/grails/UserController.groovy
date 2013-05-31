package music.grails

class UserController {

    static allowedMethods = [list: 'GET', show: 'GET', songs: 'GET', song :'GET', tags: 'GET', tag: 'POST']

    def list() {
        withFormat {
            html {
                [items: User.findAll()]
            }

            json {
                render (contentType: 'text/json') {
                    [items: User.findAll()]
                }
            }
        }
    }

    def show() {
        def user = User.get(params.id)
        withFormat {
            html {
                [user: user]
            }

            json {
                if(user) {
                render (contentType: 'text/json') {
                    user
                }
                } else {
                    render status: 404
                }
            }
        }
    }

    def songs() {
        def user = User.get(params.id)
        withFormat {
            html {
                [items: user.songs]
            }

            json {
                if(user) {
                    render (contentType: 'text/json') {
                        [items: user.songs]
                    }
                } else {
                    render status: 404
                }
            }
        }
    }

    def song() {
        def id = params.long('songId')
        def song = Song.get(id)
        withFormat {
            html {
                [song: song]
            }

            json {
                if(song) {
                    render (contentType: 'text/json') {
                        song
                    }
                } else {
                    render status: 404
                }
            }
        }
    }

    def tags() {
        def id = params.long('songId')
        def song = Song.get(id)
        withFormat {
            html {
                [items: song.tags]
            }

            json {
                if(song) {
                    render (contentType: 'text/json') {
                        [items: song.tags]
                    }
                } else {
                    render status: 404
                }
            }
        }
    }

    def tag() {
        def id = params.long('songId')
        def song = Song.get(id)
        if(song) {
            song.addToTags(params)
            song.save()
        }
        withFormat {
            html {
                [song: song]
            }

            json {
                if(song) {
                    if(song)
                    render (contentType: 'text/json') {
                        [items: song.tags]
                    }
                } else {
                    render status: 404
                }
            }
        }
    }
}
