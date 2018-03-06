package com.alemacedo.games.service

import com.alemacedo.games.model.Game
import com.alemacedo.games.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameServices{

    @Autowired
    lateinit var gameRepository : GameRepository
    fun buscarTodos() : List<Game> {
        return gameRepository.findAll()
    }

    fun salvarGame(game: Game) {
        gameRepository.save(game)
    }

    fun buscarPorNome(nome:String) : List<Game> {
        return gameRepository.findByNomeIgnoreCaseContaining(nome)
    }

    fun apagar(id:String) {
        return gameRepository.deleteById(id)
    }
}