package cz.movapp.app.ui.alphabet

data class LetterExampleData(val example: String, val transcription: String)

data class AlphabetData(val id: String, val language: String, val letter_capital: String?, val letter: String?, val letterSoundAssetFile: String?, val transcription: String, val examples: List<LetterExampleData>)