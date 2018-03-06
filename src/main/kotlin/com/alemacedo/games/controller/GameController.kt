package com.alemacedo.games.controller

import com.alemacedo.games.model.Game
import com.alemacedo.games.service.GameServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/game")
class GameController{
    @Autowired
    lateinit var gameService: GameServices

    @GetMapping
    fun buscarTodos(): List<Game> {
        return gameService.buscarTodos()
    }

    @PostMapping
    fun salvar(@RequestBody game: Game) {
        gameService.salvarGame(game)
    }

    @GetMapping (value = "/titulo/{titulo}")
    fun buscarPor(@PathVariable (value = "titulo") titulo : String) : List<Game> {
        return gameService.buscarPorNome(nome = titulo)
    }

    @DeleteMapping(value = "{id}")
    fun apagar(@PathVariable(value="id") id : String) {
        return gameService.apagar(id)
    }
}