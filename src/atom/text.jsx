import React from 'react';

const Text = ({children}) => {
    return (
        <div className='break-words font-bold sm:mt-0'>
            {children}
        </div>
    );
};

export default Text;