<%@include file="htmlheader.jsp" %>

<div class="row">
    <h1>Search & Lookup</h1>
</div>
<div class="row">
    <div class="row datapagepanel">
        <div class="row">
            <h2>Search:</h2>
            <p>I would like to find:
                <select name="whatfind" id="whatfind">
                    <option value="hro">a Hero</option>
                    <option value="pwr">a Power</option>
                    <option value="loc">a Location</option>
                    <option value="civ">a Civilian</option>
                    <option value="sit">a Sighting</option>
                    <option value="any">Any Article</option>
                </select>  
                that has 
                <select name="findhow" id="findhow">
                    <option value="nam">a Name like</option>
                    <option value="dsc">a Description containing</option>
                    <option value="any">any data that contains</option>
                </select>
                <input type="text" id="searchterm" name="searchterm">
                <input type="submit">
            </p>
        </div>
        <div class="row">
            <div id="searchresults"></div>
        </div>
    </div>
    <div class="row datapagepanel">
        <div class="row">
            <h2>Cross-Reference</h2>
        </div>
        <div class="row">
            <p>Cross Reference:
                <select name="compar1" id="compar1">
                    <option value="hero">Hero</option>
                    <option value="powr">Power</option>
                    <option value="orgz">Organizations</option>
                    <option value="loca">Locations</option>
                    <option value="sigh">Sightings</option>
                </select>
                to
                <select name="compar2" id="compar2">
                    <option value="hero">Hero</option>
                    <option value="powr">Power</option>
                    <option value="orgz">Organizations</option>
                    <option value="loca">Locations</option>
                    <option value="sigh">Sightings</option>
                </select>
                <input type="submit">
            </p>
            <p id="referencetype"></p>
        </div>
        <div class="row" id="referenceresults">

        </div>
    </div>
</div>
</div>

<%@include file="htmlfooter.jsp" %>