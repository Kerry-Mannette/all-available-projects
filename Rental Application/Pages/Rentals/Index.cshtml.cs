using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Data;
using RazorPagesRental.Models;

namespace RazorPagesRental.Pages_Rentals
{
    public class IndexModel : PageModel
    {
        private readonly RazorPagesRental.Data.RazorPagesRentalsContext _context;

        public IndexModel(RazorPagesRental.Data.RazorPagesRentalsContext context)
        {
            _context = context;
        }

        public IList<Rentals> Rentals { get;set; } = default!;

        public async Task OnGetAsync()
        {
            Rentals = await _context.Rentals.ToListAsync();
        }
    }
}
