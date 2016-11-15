package com.example.user.cardgame;

import java.util.ArrayList;

public class Game{

    Player player;
    Deckable card;
    Deck deck;
    private ArrayList<Player> players;


    public Game(){
        this.players = new ArrayList<Player>();
        this.deck = deck;
    }

    public int playerCount(){
        return players.size();
    }


    public void addPlayers(Player player){
        players.add(player);
    }



    public void deal(Deck deck){
        deck.setUpDeck();

        for ( Player player : players){
            Deckable card1 = deck.getTopCard();
            Deckable card2 = deck.getTopCard();
            player.getHand(card1, card2);
        }
    }




    public void reDeal(Deck deck){
        for (Player player : this.players){
            player.discardHand();
        }
        deck.clearDeck();
        deal(deck);
    }


    public String showAllHands(){
        String allHands = "";
        for (Player player : this.players ){
           allHands += player.showHand();
        }
        return  allHands;
    }


    public String showAllHandsProperly(){
        String allHands = "";
        for (Player player : players){
            allHands += (player.getName() + " : " + player.showHand() + "\n");
        }
        return allHands;
    }


    public Player winChecker(){

        Player winningPlayer = players.get(0);

        for (Player player : players){

            if (player.getOverallHandValue() > winningPlayer.getOverallHandValue()){
                winningPlayer = player;

            }
            return winningPlayer;
        }
        return null;
    }

    public String gamePlayAsString(){

        String playerHands = showAllHandsProperly();
        String winningPlayer = winChecker().getName();
        String result = String.format("%s but the winner is %s", playerHands, winningPlayer);
        return result;
    }



}























