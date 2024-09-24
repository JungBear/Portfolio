import React from 'react';

const TableRow = ({children}) => {
    return (
        <div className='py-5 border-b border-gray-200 md:grid md:grid-cols-5 md:gap-6'>
            {children}
        </div>
    );
};

export default TableRow;