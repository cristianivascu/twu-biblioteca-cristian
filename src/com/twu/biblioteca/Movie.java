package com.twu.biblioteca;

public class Movie implements Item{
    private String name;
    private int year;
    private String director;
    private int rating;

    public Movie(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }

    public boolean setRating(int rating) {
        if(rating > 0 && rating <=10) {
            this.rating = rating;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (rating != movie.rating) return false;
        if (year != movie.year) return false;
        if (!director.equals(movie.director)) return false;
        if (!name.equals(movie.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + year;
        result = 31 * result + director.hashCode();
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        String rating = this.rating>0 ? this.rating+"/10" : "N/A";
        return name + ", directed by "+director+ ", released in "+ year+", rating: "+rating;
    }
}

