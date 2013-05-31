class UrlMappings {

	static mappings = {

        "/rest/users" {
            controller = "user"
            action = "list"
        }

        "/rest/users/$id" {
            controller = "user"
            action = "show"
        }

        "/rest/users/$id/songs" {
            controller = "user"
            action = "songs"
        }

        "/rest/users/$id/songs/$songId" {
            controller = "user"
            action = "song"
        }

        "/rest/users/$id/songs/$songId/tags" {
            controller = "user"
            action = "tags"
        }

        "/rest/users/$id/songs/$songId/tag/$type/$tag" {
            controller = "user"
            action = "tag"
        }

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
