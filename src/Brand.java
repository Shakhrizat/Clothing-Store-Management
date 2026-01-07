public class Brand {
    private int brandId;
    private String brandName;
    private String countryOfOrigin;
    private double rating;

    public Brand(int brandId, String brandName, String countryOfOrigin, double rating) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.countryOfOrigin = countryOfOrigin;
        this.rating =rating;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        if (brandName != null && !brandName.isEmpty()) {
            this.brandName = brandName;
        } else {
            this.brandName = "No Brand";
        }
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public void updateRating(double newRating) {
        rating = newRating;
    }

    public String getBrandDetails() {
        return brandName + " (" + countryOfOrigin + "), Rating: " + rating;
    }
    public boolean isFavorable(double rating) {
        return rating>=4.5;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "Brand ID=" + brandId + '\'' +
                "Brand name=" + brandName + '\'' +
                "Origin=" + countryOfOrigin + '\'' +
                "Rating=" + rating + '\'' +        '}';
    }
}
