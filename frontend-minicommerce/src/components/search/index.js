import React from "react";
import classes from "./styles.module.css";

const Search = (props) => {
    const { searchField, actions } = props;

    return (
        <div>
            <div>
                <input
                    className={classes.searchterm}
                    type="text"
                    placeholder="Cari"
                    onChange={actions}
                    value={searchField}
                />
            </div>
        </div>
    );
}

export default Search;